package com.example.furniture.pojo;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;


@Enabled
@Data
@Table(name = "family")
public class Family implements Serializable {
  @Id
  @KeySql(useGeneratedKeys = true)
  private Long familyId;
  private String familyName;
  private String familyAddress;
  private Long existed;

}
