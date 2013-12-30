package com.practicalunittesting;

import org.testng.annotations.Test;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OriginalTest {

    Processor processor = new Processor();
    Client client = new Client();
    @Test
    public void testChargeInRetryingState() throws Exception {
        // given
        TxDTO request = createTxDTO(RequestType.CHARGE);
        AndroidTransaction androidTransaction = createAndroidTx();

        // when
        final TxDTO txDTO = processor.processRequest(request);

        // then
        assertState(txDTO, androidTransaction,
                AndroidTransactionState.CHARGED, AndroidTransactionState.CHARGE_PENDING, ExtendedState.AS_ANDROID_TX_STATE,
                ClientMessage.SUCCESS, ResultCode.SUCCESS);
    }

    private AndroidTransaction createAndroidTx() {
        return null;
    }

    private TxDTO createTxDTO(RequestType requestType) {
        return null;
    }

    private void assertState(TxDTO txDTO, AndroidTransaction androidTransaction,
                             AndroidTransactionState expectedAndroidState,
                             AndroidTransactionState expectedPreviousAndroidState,
                             ExtendedState expectedState,
                             String expectedClientStatus,
                             ResultCode expectedRequestResultCode) {
        final List<AndroidTransactionStep> steps
                = new ArrayList<AndroidTransactionStep>(androidTransaction.getTransactionSteps());
        final boolean checkPreviousStep = expectedAndroidState != null;
        assertTrue(steps.size() >= (checkPreviousStep ? 3 : 2));

        if (checkPreviousStep) {
            AndroidTransactionStep lastStep = steps.get(steps.size() - 2);
            assertEquals(lastStep.getTransactionState(),
                    expectedPreviousAndroidState);
        }

        final AndroidTransactionStep lastStep = steps.get(steps.size() - 1);
        assertEquals(lastStep.getTransactionState(), expectedAndroidState);
        assertEquals(lastStep.getMessage(), expectedClientStatus);

        assertEquals(txDTO.getResultCode(), expectedRequestResultCode);
        assertEquals(androidTransaction.getState(), expectedAndroidState);
        assertEquals(androidTransaction.getExtendedState(), expectedState);

        if (expectedClientStatus == null) {
            verifyZeroInteractions(client);
        }
    }
}
