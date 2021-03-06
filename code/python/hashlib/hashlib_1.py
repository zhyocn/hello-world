#!/usr/bin/env/python3
# -*- coding: utf-8 -*-
__author__='drawnkid@gmail.com'
import hashlib
import os,sys
def md5sum(fileName):
    md5 = hashlib.md5()
    fd = open(fileName)
    while True:
        data = fd.read(1024*4)
        if data:
            md5.update(data)
        else:
            break
    fd.close()
    return md5.hexdigest()
def md5sum2(fileName):
    md5 = hashlib.md5()
    with open(fileName) as fd:
        while True:
            data = fd.read(1024*4)
            if data:
                md5.update(data.encode('utf8'))
            else:
                break
    return md5.hexdigest()
def file_md5(topdir):
    a = os.walk(topdir)
    for p,d,f in a:
        for i in f:
            fn =os.path.join(p,i)
            md5 = md5sum2(fn)
            yield(md5,fn)

if __name__=="__main__":
    lines=''
    try:
        gen = file_md5(sys.argv[1])
        for i in gen:
            lines+=str(i)+'\n'
            #print(lines)
            print(hashlib.md5(lines.encode('utf8')).hexdigest())
            #print(i)
#        print(md5sum2(sys.argv[1]))
    except IndexError:
        print("a file is needed.")
