package com.frontline.utils;

import java.net.ServerSocket;

public class AvailablePorts {
    public int getPort() throws Exception {
        ServerSocket socket = new ServerSocket(0);
        socket.setReuseAddress(true);
        int port = socket.getLocalPort();
        socket.close();
        return port;
    }
}
