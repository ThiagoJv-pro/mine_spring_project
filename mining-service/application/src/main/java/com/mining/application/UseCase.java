package com.mining.application;

public abstract class UseCase<IN, OUT> {
    
    public abstract OUT execute(IN aCommand);
}
