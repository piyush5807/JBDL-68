package com.example.demodb;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TestIntImpl implements TestInt{

    private int num;

    @Override
    public int add(int a, int b) {
        return 0;
    }
}
