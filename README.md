# NewsSample
目的：学习mvp+dagger2+retrofit+rxjava开发模式
## 效果预览

## 为什么要使用MVP

> 在Android开发中，Activity并不是一个标准的MVC模式中的Controller，它的首要职责是加载应用的布局和初始化用户界面，并接受并处理来自用户的操作请求，进而作出响应。随着界面及其逻辑的复杂度不断提升，Activity类的职责不断增加，以致变得庞大臃肿。当我们将其中复杂的逻辑处理移至另外的一个类（Presneter）中时，Activity其实就是MVP模式中View，它负责UI元素的初始化，建立UI元素与Presenter的关联（Listener之类），同时自己也会处理一些简单的逻辑（复杂的逻辑交由Presenter处理）.
![Gif](http://img.blog.csdn.net/20150309135723885?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdmVjdG9yX3lp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
