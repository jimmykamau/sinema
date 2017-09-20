package info.jimmykamau.sinema.presentation.discover;

import info.jimmykamau.sinema.presentation.base.MvpBasePresenter;
import info.jimmykamau.sinema.presentation.base.MvpBaseView;

/**
 * Created by jimmykamau on 11/09/2017.
 */

public interface DiscoverContract {

    interface View extends MvpBaseView {}

    interface Presenter extends MvpBasePresenter<View> {}
}
