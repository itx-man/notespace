public class ArrayList //brefore generic class
{
	private Object[] elementData;
	...
	public Object get(int i) {...}
	public void add(Object o) {...}
}

//这样的实现有两个问题。当获取一个值时必须进行强制转换
ArrayList files = new ArrayList();
...
String filename = (String) files.get(0);
//此外，这里没有错误检查。可以向数组列表中添加任何类的对象
fiels.add(new File("..."));
//编译和运行都不会出错，然而在其他地方，如果将get的结果强制装换为String类型，就会产生一个错误

//泛型提供了一个更好的解决方案：类型参数(type parameters). 
//ArrayList类有一个类型参数用来知识元素的类型：
ArrayList<String> files = new ArrayList<String>();//代码可读性增强，一看就知道是数组列表包含的是String对象

//在Java SE 7及以后的版本中，构造函数可以省略泛型类型：
ArrayList<String> files = new ArrayList<>();
//省略的类型可以从变量的类型推断得出,编译器也可以很好地利用这个信息。
String fielname = files.get(0);

//编译器还知道ArrayList<String>中的add方法有一个类型为String的参数，这将比使用Object类型的参数安全一些。现在编译器可以进行检查，
//避免插入错误类型的对象。例如：
files.add(new File("...")); //can only add String objects to an ArrayList<String>
//类型参数的魅力在意：使程序具有更好的可读性和安全性

//通配符类型(wildcard type),通配符类型非常抽象，然而，它们能让类库的构建者编写出尽可能灵活的办法。

//泛型程序设计分为3个能力级别。基本级别是，仅仅使用泛型类---典型的是像ArrayList这样的集合---不必考虑它们的工作方式与原因。

//12.2 定义简单的泛型类
//一个泛型类(generic class)就是具有一个或多个类型变量的类。我们只关注泛型，而不会为数据存储的细节烦恼
public class Pair<T>
{
	private T first;
	private T second;

	public Pair() {first = null; second = null;}
	public Pair(T first, T second) {this.first = first; this.second = second;}

	public T getFirst() {return first;}
	public T getSecond() {return second;}

	public void setFirst(T newValue) {first = newValue;}
	public void setSecond(T newValue) {second = newValue;}
}

//Pair类引入了一个类型变量T，用尖括号<>括起来，并放在类名的后面。泛型类可以有多个类型变量。
//例如，可以定义Pair类，其中第一个域和第二个域使用不同的类型：
public class Pair<T, U> {...}
//类定义中的类型变量指定方法的返回类型以及域和局部变量的类型。例如：
private T first; //uses the type variable

//在Java库中，使用变量E表示集合的元素类型，K和V分别表的关键字与值得类型。T(需要时还可以用临近的字母U和S)表示"任意类型"。
//用具体的类型替换类型变量就可以实例化泛型参数，例如：
Pair<String>
//可以将结果想象成带有构造器的普通类：
Pair<String>()
Pair<String>(String, String)
//和方法:
String getFirst()
String getSecond()
void setFirst(String)
void setSecond(String)

//换句话说，泛型类可以看作普通类的工厂

