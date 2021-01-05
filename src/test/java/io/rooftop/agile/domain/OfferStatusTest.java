package io.rooftop.agile.domain;

import io.rooftop.kpi.domain.OfferStatus;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OfferStatusTest {

    @Test
    public void OfferStatus_test() throws Exception {
        // Given
        OfferStatus offer = OfferStatus.OPEN;

        // Then
        String contents = offer.getContents();
        Assertions.assertThat(offer).isEqualTo(OfferStatus.OPEN);
        Assertions.assertThat(contents).isEqualTo("모집중");

    }
}