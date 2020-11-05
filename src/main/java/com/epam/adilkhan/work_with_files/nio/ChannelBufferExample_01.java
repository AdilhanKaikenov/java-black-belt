package com.epam.adilkhan.work_with_files.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ChannelBufferExample_01 {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("text_file.txt", "rw");
             FileChannel channel = file.getChannel()) {

                                    // Reading from a file

            // The buffer can be filled with a maximum of 25 bytes, otherwise an exception will be thrown
            ByteBuffer buffer = ByteBuffer.allocate(25);

            StringBuilder stix = new StringBuilder();

            // Buffer write mode (from a file to the buffer)
            int byteRead = channel.read(buffer);
            while (byteRead > 0) {
                System.out.println("Read = " + byteRead);

                // The method changes the buffer mode from write to read mode. We can start read from file.
                buffer.flip(); // buffer read mode

                while (buffer.hasRemaining()) {
                    stix.append((char) buffer.get());
                }

                // The position is put in the buffer on the zero element, and when we write any information to the buffer,
                // the old bytes will be overwritten
                buffer.clear();
                byteRead = channel.read(buffer);
            }

            System.out.println(stix);

                                // Writing to a file

            String quote = "\n\nAlbert Einstein: “There are only two ways to live your life. " +
                    "One is as though nothing is a miracle. " +
                    "The other is as though everything is a miracle.”";

//            The first way

//            ByteBuffer buffer2 = ByteBuffer.allocate(quote.getBytes().length);
//            buffer2.put(quote.getBytes());
//            buffer2.flip(); // For Channel to read information from the buffer and write to a file
//            channel.write(buffer2);

//            The second way
            ByteBuffer buffer2 = ByteBuffer.wrap(quote.getBytes());
            channel.write(buffer2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
