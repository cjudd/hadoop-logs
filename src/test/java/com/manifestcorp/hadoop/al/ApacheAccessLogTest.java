package com.manifestcorp.hadoop.al;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ApacheAccessLogTest {

    @Test
    public void testNASALogFormat() {
        ApacheAccessLog log = ApacheAccessLog.parseFromLogLine("143.158.26.50 - - [01/Aug/1995:00:18:49 -0400] \"GET /shuttle/missions/51-d/mission-51-d.html HTTP/1.0\" 200 6544");
        assertThat(log.getIpAddress(), is(equalTo("143.158.26.50")));
        assertThat(log.getDateTimeString(), is(equalTo("01/Aug/1995:00:18:49 -0400")));
        assertThat(log.getMethod(), is(equalTo("GET")));
        assertThat(log.getEndpoint(), is(equalTo("/shuttle/missions/51-d/mission-51-d.html")));
        assertThat(log.getProtocol(), is(equalTo("HTTP/1.0")));
        assertThat(log.getResponseCode(), is(equalTo(200)));
        assertThat(log.getContentSize(), is(equalTo(6544l)));
    }
    
}