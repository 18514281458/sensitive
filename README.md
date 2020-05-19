# 数据脱敏


## 模块
* sensitive-fastjson
      用于springboot view 层数据脱敏
* sensitive-aop-service
      用于service 方法脱敏
* sensitive-core
    乱78糟代码都在这里
* sensitive-demo
    demo
* sensitive-mybatis
    mybatis 脱敏
   
 ###使用方法
 ```
@EnableSensitiveService//开启service脱敏
@EnableSensitiveMybatis//开启mybatis脱敏
public class MainRun {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MainRun.class)

                .run(args);
    }
}

```
####实体配置 

**应用于脱敏实体对象 目前SensitiveMode 支持服务接口（AOPSERVIE）和mybatis(MYBATIS)**
`@SensitiveModel(value = SensitiveMode.AOPSERVIE)`
**应用于实体对象属性**
`@SensitiveField(value = SensitiveType.CHINESE_NAME)`
```
    * 不脱
     */
    NONE,

    /**
     * 默认
     */
    DEFAUL,
    /**
     * 中文名
     */
    CHINESE_NAME,
    /**
     * 身份证号
     */
    ID_CARD,
    /**
     * 座机号
     */
    FIXED_PHONE,
    /**
     * 手机号
     */
    MOBILE_PHONE,
    /**
     * 地址
     */
    ADDRESS,
    /**
     * 电子邮件
     */
    EMAIL,
    /**
     * 银行卡
     */
    BANK_CARD
```
#####服务接口脱敏方法
**应用于服务接口**
`@SensitiveServiceAop`
**应用于服务方法**
` @SensitiveServiceAopMethod`
#####注意事项
***目前支持List<entity> 和entity 并且支持嵌套entity例如***
```
    @SensitiveField(type= SensitivieFieldType.ENTITY)
    private Demo2Model demo2Model;
    @SensitiveField(type= SensitivieFieldType.ENTITY)
    private List<Demo2Model> demo2ModelList;
```
***但是关联的实体也需要配置具体属性过滤规则，不支持map kv json等类型，因为程序无法探测你要脱敏的属性***