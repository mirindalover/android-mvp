
## how to use

### View

view interface extends IMvpView

### Presenter

#### if you have interface for Presenter

presenter interface extends IPresenterLifecycle(user lifecycle) or IMvpPresenter

#### user view

mView.xxx

### create presenter

```java
#View
MvpLifecycleHelper.from(this,new xxxPresenter());
```

### Future

when view destroy ,our presenter'mView will be null

so wo should confirm mView != null

future : use ViewProxy witch all methods confirm view not null

