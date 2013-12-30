package com.practicalunittesting;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class PacketServletTest {

    private static final String PACKET = "packet";
    private static final String TYPE = "type";
    HttpServletRequest request;
    PacketDataProcessor packetDataProcessor;
    HttpServletResponse response;
    PacketServlet servlet;

    @BeforeMethod
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        packetDataProcessor = mock(PacketDataProcessor.class);
    }

    @Test
    public void shouldProcessPacket() throws IOException, ServletException {
        //given
        given(request.getParameter(PacketApi.PACKET_PARAMETER))
                .willReturn(PACKET);
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);

        //when
        servlet.doGet(request, response);

        //then
        verify(packetDataProcessor).process(PACKET, TYPE);
    }

    @Test
    public void shouldNotProcessIfPacketParameterIsMissing()
            throws IOException, ServletException {
        //given
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);

        //when
        servlet.doGet(request, response);

        //then
        verify(packetDataProcessor, never()).process(PACKET, TYPE);
    }

    @Test
    public void shouldProcessIfPacketParameterIsMissing()
            throws IOException, ServletException {
        //given
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);

        //when
        servlet.doGet(request, response);

        //then
        verifyZeroInteractions(packetDataProcessor);
    }

    @Test
    public void shouldReturnStatus500IfThereWasAnErrorDuringProcessing()
            throws IOException, ServletException {
        //given
        given(request.getParameter(PacketApi.PACKET_PARAMETER))
                .willReturn(PACKET);
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);
        doThrow(NullPointerException.class)
                .when(packetDataProcessor).process(PACKET,TYPE);

        //when
        servlet.doGet(request, response);

        //then
        verify(response).setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @Test
    public void shouldReturnStatus500IfThereWasAnErrorDuringProcessing_Improved()
            throws IOException, ServletException {
        //given
        given(request.getParameter(PacketApi.PACKET_PARAMETER))
                .willReturn(PACKET);
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);
        doThrow(Exception.class)
                .when(packetDataProcessor).process(PACKET,TYPE);

        //when
        servlet.doGet(request, response);

        //then
        verify(response).setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}
