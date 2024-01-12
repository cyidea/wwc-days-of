package org.wwc.lists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CodecTest {
    Codec codec = new Codec();
    @Test
    void test() {
        String original = "https://leetcode.com/problems/design-tinyurl";
        String encoded = "http://tinyurl.com/1";
        String result = codec.encode(original);
        assertThat(result).isEqualTo(encoded);

        result = codec.decode(encoded);
        assertThat(result).isEqualTo(original);
    }
}