import cv2
import numpy as np
import time

# cascade location
openPalm_cascade = cv2.CascadeClassifier('C:/Users/alext/Jupyter/gestureDetection/palm.xml')
fist_cascade =  cv2.CascadeClassifier('C:/Users/alext/Jupyter/gestureDetection/fist.xml')

# Video capture
cap = cv2.VideoCapture(0)
recording =  False # indicate start or stop recording

# Video Writer
fps = cap.get(cv2.CAP_PROP_FPS) # get fps of video
fourcc = cv2.VideoWriter_fourcc(*'mp4v')
out1 = cv2.VideoWriter(r'C:\Users\alext\Desktop\AiVie\final4.mp4', fourcc, fps, (640,480), True)
videono = 0 # each sub-video number

# timestamp 
t_end = time.time() + 10  #10 seconds
start_time = time.time()

# Output path
output_dir = "C:/Users/alext/Desktop/AiVie"


def read_video():
    cap = cv2.VideoCapture("./video.mp4")
    fps = cap.get(cv2.CAP_PROP_FPS)      # OpenCV2 version 2 used "CV_CAP_PROP_FPS"
    frame_count = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
    duration = frame_count/fps
    return duration


while True: 
    curr_time = time.time()

    ok, frame = cap.read() # read frame
    if not ok:
        print("No video")
        break
    
    #############################################################
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    fists = fist_cascade.detectMultiScale(gray, 1.3, 5)
    palms = openPalm_cascade.detectMultiScale(gray, 1.2, 35)
    #############################################################
    # Detection for start recording 
    if not recording:

        for x, y, w, h in fists: # find fists to start recording
            start_time = time.time() # Mark start recording time
            print("Start")
            cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 45, 45), 2)

            if recording is False:
                vid_path = output_dir+ "/000" + str(videono) + '.mp4'
                out = cv2.VideoWriter(vid_path, fourcc, fps, (640,480), True) # declare video writer

                recording = True
                
    #############################################################
    # Detection to stop record
    if recording:
        out.write(frame)
    
        for x, y, w, h in palms:
            cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 255, 255), 2)
    
            videono += 1

            print('recording finished')
            recording = False
            out.release()


    # ############################################################
    # # Detection for restart recording
    if curr_time - start_time >= 2.0: # it has been at least 2 seconds recording

        for x, y, w, h in fists:
            print('restart')

            cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 45, 45), 2)
            out.release()
            last_recorded_time = curr_time          
            recording =  False


    cv2.imshow("frame",frame)
    k = cv2.waitKey(1) & 0xff

    # save the whole recording
    out1.write(frame)

    if k == ord("q"):
        break
        
cv2.destroyAllWindows()
out1.release()
cap.release()