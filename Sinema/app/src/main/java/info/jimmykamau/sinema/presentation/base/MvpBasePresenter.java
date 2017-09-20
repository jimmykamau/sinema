package info.jimmykamau.sinema.presentation.base;

/**
 * Created by jimmykamau on 11/09/2017.
 */

public interface MvpBasePresenter<V extends MvpBaseView> {
    void attachView(V mvpBaseView);
    void detachView();
}
