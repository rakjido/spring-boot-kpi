package io.rooftop.kpi.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class LevelStatusTest {

    @Test
    public void LevelStatus_Test() throws Exception {
        // Given
        LevelStatus levelStatus = LevelStatus.High;

        // Then
        String contents = levelStatus.getContents();
        Assertions.assertThat(levelStatus).isEqualTo(LevelStatus.High);
        Assertions.assertThat(contents).isEqualTo("상");
    }

}