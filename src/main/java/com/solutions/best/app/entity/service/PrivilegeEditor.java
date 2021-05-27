package com.solutions.best.app.entity.service;

import com.solutions.best.app.entity.Privilege;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PrivilegeEditor implements Serializable {

    private List<Privilege> _privileges;
    private List<Privilege> _deletedPrivileges;

    @Inject
    PrivilegeService privilegeService;

    @PostConstruct
    private void init() {
        _privileges = privilegeService.findAll();
        _deletedPrivileges = new ArrayList<>();
    }

    public List<Privilege> getPrivileges() {
        return _privileges;
    }

    public void setPrivileges(List<Privilege> _privileges) {
        this._privileges = _privileges;
    }

    public String addPrivilege() {
        _privileges.add(new Privilege());
        return "";
    }

    public String deleteCategory(Privilege category) {
        if (category.getId() >= 0) {
            _deletedPrivileges.add(category);
        }
        _privileges.remove(category);
        return "";
    }

    public String save() {
        for (Privilege privilege : _privileges) {
            privilegeService.save(privilege);
        }
        for (Privilege privilege : _deletedPrivileges) {
            privilegeService.delete(privilege);
        }
        _deletedPrivileges = new ArrayList<>();
        return "";
    }

}
