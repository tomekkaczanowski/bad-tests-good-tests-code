package com.practicalunittesting;

public class CompilerSupportFactory {

    private static CompilerSupport default32BitCompilerSupport;

    public static CompilerSupport getDefault32BitCompilerSupport() {
        return default32BitCompilerSupport;
    }
}
