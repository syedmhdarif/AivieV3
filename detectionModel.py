import cv2
import numpy as np
import os

from modules.rembg.bg import remove
import io
import glob
from PIL import Image,ImageFile
ImageFile.LOAD_TRUNCATED_IMAGES = True


#Video output
video_name = (r'C:\Users\alext\Desktop\output.mp4')


# kernel
kernel = np.ones((5,5),np.uint8)

def vid2frame(cap,ori_path):

    fc = 1
    while True:
        ok, frame = cap.read()
        
        if not ok:
            print("No video found")
            break

        name = (ori_path + f"\{(fc):04}" +".png")   # save frame as PNG file
        cv2.imwrite(name, frame)  
        print ('Creating...' + name) 
        fc+=1
    

def removeBackground (input_path, masking_path):
    img_dir = os.listdir(input_path) # list of image

    for item in img_dir:
        source = os.path.join(input_path,item) 
        # print (source)

        try:
            f = np.fromfile(source)
            result = remove(f)    
            img = Image.open(io.BytesIO(result)).convert("RGB") # Use "RGBA" to get alpha channel as background

            if item in masking_path:
                continue

            else:
                dest = os.path.join(masking_path,item)
                img.save(dest)
                
        except:
            continue


def final_output1(ori,mask,background):
    foreground = cv2.bitwise_or(ori,ori,mask = mask)
    masking = cv2.bitwise_not(mask) #to get the coordinates of mask
    
    background = cv2.bitwise_or(background,background, mask = masking) #to turn the masking pixels to 0
    final = cv2.bitwise_or(foreground,background)
    return final

#turn the image into masking
#input from grayscale image
def filling(masking_path):
    
    images = os.listdir(masking_path) 

    for item in images:

        thresh = cv2.imread(os.path.join(masking_path,item), cv2.IMREAD_GRAYSCALE)
        thresh = cv2.blur(thresh, (3,3))
        gradient = cv2.morphologyEx(thresh, cv2.MORPH_GRADIENT, kernel)

        im_floodfill = gradient.copy()

        # the masking image
        # Notice the size needs to be 2 pixels than the image.
        h, w = thresh.shape[:2]
        mask = np.zeros((h+2, w+2), np.uint8)

        #filling the background pixels into white
        cv2.floodFill(im_floodfill, mask, (1,1), 255);  
       
        ret, im_floodfill = cv2.threshold(im_floodfill, 240, 255, cv2.THRESH_BINARY)
        im_floodfill = cv2.morphologyEx(im_floodfill, cv2.MORPH_OPEN, kernel,iterations = 1)
        im_floodfill = cv2.dilate(im_floodfill, kernel, iterations = 3)
        im_floodfill = cv2.erode(im_floodfill, kernel, iterations = 1)

        #revert it
        im_floodfill_inv = cv2.bitwise_not(im_floodfill) 

        #Writing
        cv2.imwrite(os.path.join(masking_path,item),im_floodfill_inv)

    return 0


def frame2video(fps,input_path):
    img_array = []
    fourcc = cv2.VideoWriter_fourcc(*'mp4v')

    for filename in glob.glob( input_path + '/*.png'):
        img = cv2.imread(filename)
        h, w, c = img.shape
        img_array.append(img)


    out = cv2.VideoWriter(video_name, fourcc, fps, (w, h), True)
    
    for i in range(len(img_array)):
        out.write(img_array[i])

    out.release()


def main():
    
    #video input
    video = (r'C:\Users\alext\Desktop\0002.mp4')
    cap = cv2.VideoCapture(video)
    fps = cap.get(cv2.CAP_PROP_FPS)


    #writer
    writer = None
    #path
    ori_path = (r"C:\Users\alext\Desktop\AiVie\temp\ori") # original image location
    masking_path = (r"C:\Users\alext\Desktop\AiVie\temp\mask") # Masking image location
    background = cv2.imread("C:/Users/alext/Downloads/Workspace.JPEG",1) #Background image

    vid2frame(cap,ori_path)
    removeBackground(ori_path, masking_path) # remove the original path background and save into masking path
    filling(masking_path) # turn the removed background images into masking

    ###########################################
    #apply background
    images = os.listdir(ori_path)
    for item in images:

        ori = os.path.join(ori_path, item) #original frame 
        masking = os.path.join(masking_path,item) # masking frame

        #reading
        ori = cv2.imread(ori,1) # read the raw image
        masking = cv2.imread(masking,0) # read the masking image
        background = cv2.resize(background,(ori.shape[1],ori.shape[0])) # resize the background to fit in the image
    
        final = final_output1(ori,masking, background)  
        final_path = os.path.join(ori_path,item)
        cv2.imwrite(final_path,final)
    #################################
    frame2video (fps,ori_path) #write into video
    cap.release()


if __name__ == '__main__':
    import cProfile
    cProfile.run('main()')

cv2.destroyAllWindows()