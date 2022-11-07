package uz.team.sabredu.service;

import uz.team.sabredu.dao.AuthUserDao;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.dto.auth.RegisterDto;
import uz.team.sabredu.exceptions.BadRequestException;
import uz.team.sabredu.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.function.Function;

public class AuthUserService extends Service<AuthUserDao> {

    public AuthUserService(AuthUserDao dao) {
        super(dao);
    }

    public void create(HttpServletRequest req) {
        RegisterDto registerDto = toUserCDTO.apply(req);
        AuthUser user = toUser.apply(registerDto);
        dao.persist(user);
    }

    private static final Function<HttpServletRequest, RegisterDto> toUserCDTO = RegisterDto::toDTO;
    private static final Function<RegisterDto, AuthUser> toUser = RegisterDto::toDomain;


    public AuthUser login(String l_phone, String l_password) {
        AuthUser authUser = dao.findByUsername(l_phone).orElseThrow(() -> {
            throw new BadRequestException("Bad credentials");
        });
        if (!Utils.matchPassword(l_password, authUser.getLogin().getPassword())) {
            throw new BadRequestException("Bad credentials");
        }
        return authUser;
    }

    public AuthUser findByID(Long id) {
        return dao.findOne(id);
    }

    public List<AuthUser> findAll(){
        List<AuthUser> all = dao.findAll();
        return all;
    }

    public void update(AuthUser user) {
        dao.update(user);
    }


    public void buyThisCourse(AuthUser user, Course course) {
        dao.buyThisCourse(user.getId(),course.getId());
    }
}
