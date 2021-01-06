package io.rooftop.kpi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LevelStatus {
//    High,
//    Medium,
//    Low;

    High("상"),
    Medium("중"),
    Low("하");

    private String contents;
}
