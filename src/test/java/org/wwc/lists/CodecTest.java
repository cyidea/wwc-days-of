package org.wwc.lists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CodecTest {
    Codec codec = new Codec();
    @Test
    void encode() {
        String original = "https://leetcode.com/problems/design-tinyurl";
        String encoded = "http://tinyurl.com/aHR0cHM6Ly9sZWV0Y29kZS5jb20vcHJvYmxlbXMvZGVzaWduLXRpbnl1cmw=";
        String result = codec.encode(original);
        assertThat(result).isEqualTo(encoded);
    }

    @Test
    void decode() {
        String original = "https://leetcode.com/problems/design-tinyurl";
        String encoded = "http://tinyurl.com/aHR0cHM6Ly9sZWV0Y29kZS5jb20vcHJvYmxlbXMvZGVzaWduLXRpbnl1cmw=";
        String result = codec.decode(encoded);
        assertThat(result).isEqualTo(original);
    }
}