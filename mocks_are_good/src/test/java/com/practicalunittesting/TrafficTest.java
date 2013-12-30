package com.practicalunittesting;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TrafficTest {

    @Test
    public void shouldGetTrafficTrend() {
        //given
        TrafficTrendProvider trafficTrendProvider
                = mock(TrafficTrendProvider.class);
        Report report = new Report(null, "", 1, 2, 3,
                BigDecimal.ONE, BigDecimal.ONE, 1);
        TrafficTrend trafficTrend = new TrafficTrend(report, report,
                new Date(), new Date(), new Date(), new Date());
        given(trafficTrendProvider.getTrafficTrend()).willReturn(trafficTrend);
        TrafficService service = new TrafficService(trafficTrendProvider);

        //when
        TrafficTrend result = service.getTrafficTrend();

        //then
        assertThat(result).isEqualTo(trafficTrend);
    }

    @Test
    public void shouldGetTrafficTrend_UsingMocks() {
        //given
        TrafficTrendProvider trafficTrendProvider
                = mock(TrafficTrendProvider.class);
        TrafficTrend trafficTrend = mock(TrafficTrend.class);
        given(trafficTrendProvider.getTrafficTrend()).willReturn(trafficTrend);
        TrafficService service = new TrafficService(trafficTrendProvider);

        //when
        TrafficTrend result = service.getTrafficTrend();

        //then
        assertThat(result).isEqualTo(trafficTrend);
    }
}
