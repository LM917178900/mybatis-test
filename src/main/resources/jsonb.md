
实现postGRE数据库保存JSONObject\JSONArray

### 1. 新建java 对象 JsonTypeHandler;
#### 1.1 修改注解
@MappedTypes({JSONObject.class})
#### 1.2 重写方法 
@Override
 public Map getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
     return JSONObject.parseObject(resultSet.getString(columnName));
 }
 
### 2. 查询
映射类型写法
    <resultMap>
        <result column="log_data" property="logData"
                typeHandler="com.example.demo.mybatis.JsonTypeHandler"
                javaType="com.alibaba.fastjson.JSONObject"/>
    </resultMap>
### 3. 新增和修改
<if test="record.logData == null">null</if>
<if test="record.logData != null">(#{record.logData,typeHandler=com.example.demo.mybatis.JsonTypeHandler}) </if>
   