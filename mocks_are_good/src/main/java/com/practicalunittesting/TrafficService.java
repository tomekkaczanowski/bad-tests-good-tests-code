package com.practicalunittesting;

public class TrafficService {
    private TrafficTrend trafficTrend;

    public TrafficService(TrafficTrendProvider trafficTrendProvider) {

    }

    public TrafficTrend getTrafficTrend() {
        return trafficTrend;
    }
}
