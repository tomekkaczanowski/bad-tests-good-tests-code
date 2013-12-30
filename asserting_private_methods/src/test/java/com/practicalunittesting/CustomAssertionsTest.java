package com.practicalunittesting;

import org.testng.annotations.Test;

public class CustomAssertionsTest {

    Processor processor = new Processor();

    @Test
    public void testChargeInRetryingState() throws Exception {
        // given
        TxDTO request = createTxDTO(RequestType.CHARGE);
        AndroidTransaction androidTransaction = createAndroidTx();
        // when
        final TxDTO txDTO = processor.processRequest(request);
        // then
//        assertThat(androidTransaction).hasState(AndroidTransactionState.CHARGED)
//                .hasMessage(ClientMessage.SUCCESS)
//                .hasPreviousState(AndroidTransactionState.CHARGE_PENDING)
//                .hasExtendedState(null);
//        assertEquals(txDTO.getResultCode(),
//                ResultCode.SUCCESS);
    }

    private AndroidTransaction createAndroidTx() {
        return null;
    }

    private TxDTO createTxDTO(RequestType requestType) {
        return null;
    }
}
