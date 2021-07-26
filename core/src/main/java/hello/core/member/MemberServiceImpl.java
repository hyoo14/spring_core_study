package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//특수한 경우 이름 부여("memberService2")
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired //마치 ac.getBean(MemberRepository.class) 처럼 기능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //for test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
