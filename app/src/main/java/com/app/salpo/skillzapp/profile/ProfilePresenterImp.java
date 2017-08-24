package com.app.salpo.skillzapp.profile;

import com.app.salpo.skillzapp.models.Skill;
import com.app.salpo.skillzapp.models.User;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderPresenter;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderView;

import java.util.Arrays;
import java.util.List;
import android.os.Handler;
/**
 * Created by arunaj on 8/23/17.
 */

public class ProfilePresenterImp implements ProfilePresenter {

    public ProfileView profileView;
    public List<Skill> skillList;


    public ProfilePresenterImp(ProfileView profileView) {
        this.profileView = profileView;

    }


    @Override
    public void onDestroy() {
        profileView = null;
    }

    @Override
    public void onSkillClicked(int position) {
        Skill singleSkill = skillList.get(position);
        //profileView.showEditSkillDialog(singleSkill.getSkillType(),singleSkill.getSkillName(),singleSkill.getRate());


    }

    @Override
    public void bindViewHolderRow(SkillViewHolderPresenter skillViewHolderPresenter, int position) {
        Skill skill = skillList.get(position);
        skillViewHolderPresenter.showSkill(skill);

    }

    @Override
    public int getItemCount() {
        if (skillList == null) {
            return 0;
        }
        return skillList.size();
    }

    @Override
    public void fetchProfile() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User u1 = new User(
                        "aruna","Intern","image",Arrays.asList(
                        new Skill("java","mobile","12/08/2017",3),
                        new Skill("C#","mobile","02/08/2017",4),
                        new Skill("PHP","web","02/08/2017",2))
                );

                skillList = u1.getSkillsList();
                profileView.notifySkillList();

                profileView.setUsername(u1.getUsername());
                profileView.setDesignation(u1.getDesignation());
            }
        }, 5000);

    }

}
