package com.epam.adilkhan.work_with_files.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample_02 {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("test_text_file_01.txt", "r");
             FileChannel channel = file.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip(); // read mode
            System.out.println(((char) buffer.get())); // a - 0
            System.out.println(((char) buffer.get())); // b - 1
            System.out.println(((char) buffer.get())); // c - 2
            buffer.rewind(); // The method will place the position on the zero cell
            System.out.println(((char) buffer.get())); // a - 0 again

            System.out.println("======================================");
            // The compact() method is used when we do not want to use the clear() method.
            // When we do not want to waste unread bytes, but we need to write something to the buffer.
            buffer.compact();
            channel.read(buffer);
            buffer.flip(); // read mode

            while (buffer.hasRemaining()) {
                System.out.println(((char) buffer.get()));
            }

            System.out.println("======================================");
            buffer.clear(); // position = 0
            channel.read(buffer); // wrote the remaining characters to the buffer
            buffer.flip(); // read mode
            System.out.println(((char) buffer.get())); // g
            buffer.mark(); // mark position on 'h' character
            System.out.println(((char) buffer.get())); // h
            System.out.println(((char) buffer.get())); // i
            buffer.reset(); // return to the marked position
            while (buffer.hasRemaining()) {
                System.out.println(((char) buffer.get()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
