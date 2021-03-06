package org.sabio.sabioapp.presentation.presenter;

import android.util.Log;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.Utils.SharedPreferencesUtil;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.ICountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.ICountryUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueUseCase;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamRestUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.repository.ILocalDataRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/17/17.
 */

public class AuthPresenter implements AuthContract.UserActionListener {

    private AuthContract.View view;
    private ILocalDataUseCase localDataUseCase;


    public AuthPresenter(AuthContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();

    }


    @Override
    public void goToFirstFragment() {
        try {;
            Boolean isAuth = localDataUseCase.getData(Constant.SHARED_PREF_IS_AUTH, Boolean.class);

            if (isAuth == null || !isAuth) {
                view.goToLoginFragment();
            } else {
                view.goToMainActivity();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
