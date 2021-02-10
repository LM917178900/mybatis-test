
mybatis-plus 和 mybatis 不同之处

### 1.pom 配置
2. mybatis项目导入依赖：mybatis-plus-boot-starter


### 3. yml配置   
2. 日志配置
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

### 4. 代码
1. mapper extends BaseMapper<SysTask>
2. serviceImpl  extends ServiceImpl<PlusMapper, SysTask>

### 5. 对象注解
####1. @TableName("sys_log") 
关联数据库表名称
####2. @TableId(value = "id",type = IdType.AUTO)
关联数据库字段id,
type = IdType.AUTO表示使用数据库配置的自增序列，没有type默认使用snowFlake主键，type 还有其他类型，略；
####3.@TableField(exist = false)
改字段被忽略，当数据库查询返回映射时，否则会报错，找不到隐射字段；
