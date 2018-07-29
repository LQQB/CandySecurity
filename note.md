SpringMVC 常用注解回顾

@RequestParam 参数绑定的一种,常用来处理简单类型的绑定,处理 URL 参数类似于这种
url = “${ctx}/edit?Id=${Id}&name=${name}”
@RequestMapping("/edit")
    public String edit(@RequestParam Map<String, Object> paramMap ) {
        long id = Long.parseLong(paramMap.get("id").toString());
        String name = paramMap.get("name").toString;
        return page("edit");
    }

@PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中,处理的 URL 参数类似于这种:
url = “${ctx}/edit/${Id}/${name}”

@RequestMapping("/edit/{id}/{name}")
    public String edit(@PathVariable long id,@PathVariable String name) {

        return page("edit");
    }

注意: 前端传参的URL于后端@RequestMapping的URL必须相同且参数位置一一对应，否则前端会找不到后端地址


@JsonView
    使用接口来声明多个视图
    在值对象get 方法上指定视图
    类或接口间的继承，也是视图之间的继承，继承后的视图会包含上级视图注解的方法


@RequestBody  映射请求体到方法的参数



一个@Valid的参数后必须紧挨着一个BindingResult 参数，否则spring会在校验不通过时直接抛出异常

JSR303定义的校验类型
    空检查
    @Null       验证对象是否为null
    @NotNull    验证对象是否不为null, 无法查检长度为0的字符串
    @NotBlank 检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
    @NotEmpty 检查约束元素是否为NULL或者是EMPTY.

    Booelan检查
    @AssertTrue     验证 Boolean 对象是否为 true
    @AssertFalse    验证 Boolean 对象是否为 false

    长度检查
    @Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
    @Length(min=, max=) Validates that the annotated string is between min and max included.

    日期检查
    @Past           验证 Date 和 Calendar 对象是否在当前时间之前
    @Future     验证 Date 和 Calendar 对象是否在当前时间之后
    @Pattern    验证 String 对象是否符合正则表达式的规则

    数值检查，建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为"",Integer为null
    @Min            验证 Number 和 String 对象是否大等于指定的值
    @Max            验证 Number 和 String 对象是否小等于指定的值
    @DecimalMax 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
    @DecimalMin 被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度
    @Digits     验证 Number 和 String 的构成是否合法
    @Digits(integer=,fraction=) 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。

    @Range(min=, max=) 检查数字是否介于min和max之间.
    @Range(min=10000,max=50000,message="range.bean.wage")
    private BigDecimal wage;

    @Valid 递归的对关联对象进行校验, 如果关联对象是个集合或者数组,那么对其中的元素进行递归校验,如果是一个map,则对其中的值部分进行校验.(是否进行递归验证)
    @CreditCardNumber信用卡验证
    @Email  验证是否是邮件地址，如果为null,不进行验证，算通过验证。
    @ScriptAssert(lang= ,script=, alias=)
    @URL(protocol=,host=, port=,regexp=, flags=)

@Target、@Retention、@Inherited、@Documented为元注解（meta-annotation），
它们是负责注解其他注解的。
1. Target：指明注解支持的使用范围，取值可以参考枚举ElementType，以下：
    ElementType.TYPE //类、接口、枚举
    ElementType.FIELD //属性
    ElementType.METHOD //方法
    ElementType.PARAMETER //参数
    ElementType.CONSTRUCTOR //构造器
    ElementType.LOCAL_VARIABLE //局部变量
    ElementType.ANNOTATION_TYPE //注解
    ElementType.PACKAGE //包

2. Retention：指明注解保留的的时间长短，取值参考枚举RetentionPolicy，一下：
    SOURCE //源文件中保留
    CLASS //class编译时保留
    RUNTIME //运行时保留
