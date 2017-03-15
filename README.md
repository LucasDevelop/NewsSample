# NewsSample
目的：学习mvp+dagger2+retrofit+rxjava开发模式
## 效果预览

## 为什么要使用MVP

> 在Android开发中，Activity并不是一个标准的MVC模式中的Controller，它的首要职责是加载应用的布局和初始化用户界面，并接受并处理来自用户的操作请求，进而作出响应。随着界面及其逻辑的复杂度不断提升，Activity类的职责不断增加，以致变得庞大臃肿。当我们将其中复杂的逻辑处理移至另外的一个类（Presneter）中时，Activity其实就是MVP模式中View，它负责UI元素的初始化，建立UI元素与Presenter的关联（Listener之类），同时自己也会处理一些简单 的逻辑（复杂的逻辑交由Presenter处理）.
![Gif](http://img.blog.csdn.net/20150309135723885? > watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdmVjdG9yX3lp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Sout> hEast)

## dagger2是什么？有什么优势？
> Dagger2是Dagger的升级版，是一个依赖注入框架，现在由Google接手维护。 恩，这里有个关键字依赖注入，因此我们得先知道什么是依赖注入，才能更好的理解Dagger2。依赖注入是面向对象编程的一种设计模式，其目的是为了降低程序耦合，这个耦合就是类之间的依赖引起的。在mvp中，最常见的一种依赖关系，就是Activity持有presenter的引用，并在Activity中实例化这个presenter，即Activity依赖presenter，presenter又需要依赖View接口，从而更新UI。
主要的注解:
*	@Provides: 用来修饰方法，方法的返回类型就是所提供的依赖类型，可以简单的把方法的返回值理解为我们通常要new出来的对象.
*	@Provides方法都会用provide作为前缀
*	@Module: 所有的@Provides方法都必须放到一个Moudle中,一个Moudle就是使用@Moudle修饰的类,可以简单的理解为一个持有各种对象的仓库.用来给@Component组件提供实例化的对象.
*	Android中有三种Module:ApplicationModule，ActivityModule，UserModule,分别提供整个应用级别的（只生成一个该组件的实例），Activity级别的，用户级别的Module。
*	@Module类都用Module作为后缀
*	@Inject: 通常在需要依赖的地方使用这个注解,简单的理解为声明一个对象
*	@Component 它是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分.
*	我们必须用@Component注解一个接口,为该注解传入Module类，或者添加其依赖的组件
*	@Component注解的接口或抽象类以Component为后缀
*	@Component的实现类
*	@Component注解的接口或抽象类，Dagger将会为该接口或者抽象类生成一个实现，这个实现的命名是在接口或抽象类前面加上Dagger，如MyComponent生成的实现是DaggerMyComponent

## retrofit是什么？
> Retrofit是Square开发的一个Android和Java的REST客户端库。这个库非常简单并且具有很多特性，相比其他的网络库，更容易让初学者快速掌握。它可以处理GET、POST、PUT、DELETE…等请求，还可以使用picasso加载图片。
请求方法:@GET / @POST / @PUT / @DELETE / @HEAD(具体使用请参考：http://blog.csdn.net/wy819/article/details/51353102)

## 什么是RXjava
> RxJava 是一个响应式编程框架，采用观察者设计模式。
RxJava 是一个开源项目，地址：https://github.com/ReactiveX/RxJava
还有一个RxAndroid，用于 Android 开发，添加了 Android 用的接口。地址：https://github.com/ReactiveX/RxAndroid
