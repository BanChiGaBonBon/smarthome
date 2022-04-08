package com.example.furniture.pojo;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;


@Enabled
@Data
@Table(name = "user")
public class User implements Serializable {
  @Id
  @KeySql(useGeneratedKeys = true)
  private Long userId;
  private String userName;
  private String userPassword;
  private Long familyId;
  private Long existed;
  private Administrator administrator;
  private Family family;
}
