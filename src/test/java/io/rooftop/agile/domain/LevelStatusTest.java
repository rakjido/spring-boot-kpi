package io.rooftop.agile.domain;

import io.rooftop.kpi.domain.LevelStatus;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class LevelStatusTest {

    @Test
    public void LevelStatus_테스트() throws Exception {
        // Given
        LevelStatus levelStatus = LevelStatus.High;

        // Then
        String contents = levelStatus.getContents();
        Assertions.assertThat(levelStatus).isEqualTo(LevelStatus.High);
        Assertions.assertThat(contents).isEqualTo("상");
    }

}