package org.atomhopper.adapter.request.impl;

import org.atomhopper.adapter.request.adapter.impl.PostEntryRequestImpl;
import org.atomhopper.adapter.request.adapter.impl.RequestParsingException;
import java.io.IOException;
import org.apache.abdera.protocol.server.RequestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

@RunWith(Enclosed.class)
public class PostEntryRequestImplTest {

    public static class WhenParsingAdberaRequestContexts {

        private RequestContext requestContextMock;
        
        @Before
        public void standUp() throws Exception {
            requestContextMock = mock(RequestContext.class);
            
            when(requestContextMock.getDocument()).thenThrow(new IOException("Unable to read stream"));
        }
        
        @Test (expected = RequestParsingException.class)
        public void shouldWrapExceptionCasesGracefully() {
            new PostEntryRequestImpl(requestContextMock).getEntry();
        }
    }
}
