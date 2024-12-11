package org.koreait.file.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
@Data
@RedisHash(value = "test_hash",timeToLive = 300)
public class RedisItem {
    @Id
    private String key;
    private int price;
    private String productNm;
}
