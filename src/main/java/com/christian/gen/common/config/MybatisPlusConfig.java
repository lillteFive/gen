package com.christian.gen.common.config;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration
@MapperScan("com.christian.gen.*.mapper*")
public class MybatisPlusConfig {
   /*
    * 分页插件，自动识别数据库类型
    * 多租户，请参考官网【插件扩展】
    */
   @Bean
   public PaginationInterceptor paginationInterceptor() {
      PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
      paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
      
      /**
       * 攻击 SQL 阻断解析器
       * 作用！阻止恶意的全表更新删除
       */
      List<ISqlParser> sqlParserList = new ArrayList<>();
      // 攻击 SQL 阻断解析器、加入解析链
      sqlParserList.add(new BlockAttackSqlParser());
      paginationInterceptor.setSqlParserList(sqlParserList);
      
      return paginationInterceptor;
   }

 	//配置乐观锁设置
 	@Bean
 	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
 	    return new OptimisticLockerInterceptor();
 	}
 	
}