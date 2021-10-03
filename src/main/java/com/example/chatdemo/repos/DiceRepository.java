package com.example.chatdemo.repos;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//TODO[] Das Template muss dahin gehend angepasst werden, dass es die werte von der API übernimmt

@Repository
@EnableJpaRepositories
public interface DiceRepository {


}
