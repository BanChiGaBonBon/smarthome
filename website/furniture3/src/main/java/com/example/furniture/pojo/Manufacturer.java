package com.example.furniture.pojo;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;


@Enabled
@Data
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
  @Id
  @KeySql(useGeneratedKeys = true)
  private Long manufacturerId;
  private String manufacturerName;
  private String manufacturerPassword;
}
