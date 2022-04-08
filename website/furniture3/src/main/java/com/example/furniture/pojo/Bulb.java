package com.example.furniture.pojo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;


@Enabled
@Data
@Table(name = "bulb")
public class Bulb implements Serializable {
  @Id
  @KeySql(useGeneratedKeys = true)
  private Long equipmentId;
  private Date measureTime;
  private String equipmentType;
  private Long ifopen;
  private Long brightness;
  private Long existed;
}
