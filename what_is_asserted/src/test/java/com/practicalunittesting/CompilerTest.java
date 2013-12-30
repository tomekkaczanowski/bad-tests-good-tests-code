package com.practicalunittesting;

import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;

public class CompilerTest {

    @Test
    public void testCompile_32Bit_FakeSourceFile() {
        CompilerSupport _32BitCompilerSupport
                = CompilerSupportFactory.getDefault32BitCompilerSupport();
        testCompile_FakeSourceFile(_32BitCompilerSupport);
    }

    private void testCompile_FakeSourceFile(
            CompilerSupport compilerSupport) {
        String[] compiledFiles
                = compilerSupport.compile(new File[] { new File("fake") });
        assertThat(compiledFiles, is(emptyArray()));
    }
}
