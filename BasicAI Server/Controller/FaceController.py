from bottle import *
from Computer_Vision import Face_Detector as FD

@get('/basicai/facedetector/<img>')
def detectface(img):
    response.content_type = 'image/jpeg'
    return FD.detect(img)

run(host='10.99.23.175', port=8080, reloader=True, debug=True)