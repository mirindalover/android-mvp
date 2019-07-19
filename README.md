
## how to use

### View

view interface extends IMvpView

### Presenter

#### if you have interface for Presenter

presenter interface extends IPresenterLifecycle(user lifecycle) or IMvpPresenter

#### user view

getView().xxx

### create presenter

```java
#View
MvpLifecycleHelper.from(this,new xxxPresenter());
```


