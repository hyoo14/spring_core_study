package Tmax.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //이제 interface에만 의존

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //MemberServiceImpl is dependent to MemberRepository and also MemoryMemberRepository

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
