package com.testing.demo.Numeric;

public enum EProfesion {
    jardinero, piscinero, podador_palmeras;

    public EProfesion getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
