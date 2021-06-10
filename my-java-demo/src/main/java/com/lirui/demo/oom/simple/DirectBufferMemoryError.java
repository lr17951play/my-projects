package com.lirui.demo.oom.simple;

import java.nio.ByteBuffer;

public class DirectBufferMemoryError {

    public static void main(String[] args) {
        /** not support for openjdk 11 */
        //System.out.println("配置的MaxDirectMemorySize:"+sun.misc.VM.maxDirectMemory()/(double)1024/1024+" MB");
        ByteBuffer nativeMom = ByteBuffer.allocateDirect(6*1024*1024);
        ByteBuffer heapMom = ByteBuffer.allocate(6*1024*1024);
    }
}
