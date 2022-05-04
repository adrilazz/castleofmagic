package world.creation.factorymethod;

import world.Mobile;
import world.state.State4Mobile;
import world.state.StateAgressive;
import world.state.StateDamian;
import world.state.StateGreets;
import world.state.StateMutters;
import world.state.StatePassiveAgressive;
import world.state.movers.Mover1;
import world.state.movers.Mover10;
import world.state.movers.Mover11;
import world.state.movers.Mover12;
import world.state.movers.Mover13;
import world.state.movers.Mover14;
import world.state.movers.Mover15;
import world.state.movers.Mover2;
import world.state.movers.Mover27;
import world.state.movers.Mover3;
import world.state.movers.Mover32;
import world.state.movers.Mover33;
import world.state.movers.Mover34;
import world.state.movers.Mover35;
import world.state.movers.Mover36;
import world.state.movers.Mover37;
import world.state.movers.Mover38;
import world.state.movers.Mover4;
import world.state.movers.Mover41;
import world.state.movers.Mover42;
import world.state.movers.Mover43;
import world.state.movers.Mover44;
import world.state.movers.Mover5;
import world.state.movers.Mover55;
import world.state.movers.Mover6;
import world.state.movers.Mover60;
import world.state.movers.Mover67;
import world.state.movers.Mover68;
import world.state.movers.Mover69;
import world.state.movers.Mover7;
import world.state.movers.Mover700;
import world.state.movers.Mover702;
import world.state.movers.Mover703;
import world.state.movers.Mover704;
import world.state.movers.Mover730;
import world.state.movers.Mover731;
import world.state.movers.Mover742;
import world.state.movers.Mover743;
import world.state.movers.Mover744;
import world.state.movers.Mover745;
import world.state.movers.Mover752;
import world.state.movers.Mover753;
import world.state.movers.Mover755;
import world.state.movers.Mover761;
import world.state.movers.Mover762;
import world.state.movers.Mover763;
import world.state.movers.Mover764;
import world.state.movers.Mover765;
import world.state.movers.Mover766;
import world.state.movers.Mover767;
import world.state.movers.Mover8;
import world.state.movers.Mover800;
import world.state.movers.Mover801;
import world.state.movers.Mover802;
import world.state.movers.Mover815;
import world.state.movers.Mover816;
import world.state.movers.Mover870;
import world.state.movers.Mover871;
import world.state.movers.Mover899;
import world.state.movers.Mover9;
import world.state.movers.Mover900;
import world.state.movers.Mover901;
import world.state.movers.Mover907;
import world.state.movers.Mover910;
import world.state.movers.Mover911;
import world.state.movers.Mover913;
import world.state.movers.Mover914;
import world.state.movers.Mover915;
import world.state.movers.Mover916;
import world.state.movers.Mover917;
import world.state.movers.Mover918;
import world.state.movers.Mover919;
import world.state.movers.Mover920;
import world.state.movers.Mover921;
import world.state.movers.Mover922;
import world.state.movers.Mover923;
import world.state.movers.Mover924;
import world.state.movers.Mover925;
import world.state.movers.Mover926;
import world.state.movers.Mover927;
import world.state.movers.Mover928;
import world.state.movers.Mover929;
import world.state.movers.Mover930;
import world.state.movers.Mover931;
import world.state.movers.Mover932;
import world.state.movers.Mover933;
import world.state.movers.Mover934;
import world.state.movers.Mover941;
import world.state.movers.Mover942;
import world.state.movers.StateRuth;

public class StateEncoder {

	public static State4Mobile buildState(String whichStrategy, String message4strategy, Mobile temp) {
		
		State4Mobile specificStrategy = null;
		
		switch(whichStrategy) {
			case "G": 
				specificStrategy = new StateGreets();
				break;

			case "PA": 
				specificStrategy = new StatePassiveAgressive();
				break;

			case "A": 
				specificStrategy = new StateAgressive();
				break;

			case "M": 
				StateMutters m = new StateMutters(message4strategy);
				m.setMobile(temp);
				specificStrategy = m;				
				break;		
			
			case "DAMIAN": 
				StateDamian d = new StateDamian(message4strategy);
				d.setMobile(temp);
				specificStrategy = d;				
				break;		
				
			case "Mover11":
				Mover11 mover = new Mover11();
				mover.setMobile(temp);
				specificStrategy = mover;
				break;
			
			case "Mover12":
				Mover12 mover12 = new Mover12();
				mover12.setMobile(temp);
				specificStrategy = mover12;
				break;
				
			case "Mover13":
				Mover13 mover13 = new Mover13();
				mover13.setMobile(temp);
				specificStrategy = mover13;
				break;
			
			case "Mover14":
				Mover14 mover14 = new Mover14();
				mover14.setMobile(temp);
				specificStrategy = mover14;
				break;
			
			case "Mover15":
				Mover15 mover15 = new Mover15();
				mover15.setMobile(temp);
				specificStrategy = mover15;
				break;
			
			case "Mover27":
				Mover27 mover27 = new Mover27();
				mover27.setMobile(temp);
				specificStrategy = mover27;
				break;
			
			case "Mover32":
				Mover32 mover32 = new Mover32();
				mover32.setMobile(temp);
				specificStrategy = mover32;
				break;
			case "Mover33":
				Mover33 mover33 = new Mover33();
				mover33.setMobile(temp);
				specificStrategy = mover33;
				break;
			case "Mover34":
				Mover34 mover34 = new Mover34();
				mover34.setMobile(temp);
				specificStrategy = mover34;
				break;
			case "Mover35":
				Mover35 mover35 = new Mover35();
				mover35.setMobile(temp);
				specificStrategy = mover35;
				break;
			case "Mover36":
				Mover36 mover36 = new Mover36();
				mover36.setMobile(temp);
				specificStrategy = mover36;
				break;
			case "Mover37":
				Mover37 mover37 = new Mover37();
				mover37.setMobile(temp);
				specificStrategy = mover37;
				break;
			case "Mover38":
				Mover38 mover38 = new Mover38();
				mover38.setMobile(temp);
				specificStrategy = mover38;
				break;
			case "Mover41":
				Mover41 mover41 = new Mover41();
				mover41.setMobile(temp);
				specificStrategy = mover41;
				break;
			case "Mover42":
				Mover42 mover42 = new Mover42();
				mover42.setMobile(temp);
				specificStrategy = mover42;
				break;	
			case "Mover43":
				Mover43 mover43 = new Mover43();
				mover43.setMobile(temp);
				specificStrategy = mover43;
				break;
			case "Mover44":
				Mover44 mover44 = new Mover44();
				mover44.setMobile(temp);
				specificStrategy = mover44;
				break;
			case "Mover55":
				Mover55 mover55 = new Mover55();
				mover55.setMobile(temp);
				break;
			case "Mover60":
				Mover60 mover60 = new Mover60();
				mover60.setMobile(temp);
				break;
			case "Mover67":
				Mover67 mover67 = new Mover67();
				mover67.setMobile(temp);
				break;
			case "Mover68":
				Mover68 mover68 = new Mover68();
				mover68.setMobile(temp);
				break;
			case "Mover69":
				Mover69 mover69 = new Mover69();
				mover69.setMobile(temp);
				break;
			case "Mover700":
				Mover700 mover700 = new Mover700();
				mover700.setMobile(temp);
				break;
			case "Mover702":
				Mover702 mover702 = new Mover702();
				mover702.setMobile(temp);
				break;
			case "Mover703":
				Mover703 mover703 = new Mover703();
				mover703.setMobile(temp);
				break;
			case "Mover704":
				Mover704 mover704 = new Mover704();
				mover704.setMobile(temp);
				break;
			case "Mover730":
				Mover730 mover730 = new Mover730();
				mover730.setMobile(temp);
				break;
			case "Mover731":
				Mover731 mover731 = new Mover731();
				mover731.setMobile(temp);
				break;
			case "StateRuth": 
				StateRuth r = new StateRuth();
				r.setMobile(temp);
				specificStrategy = r;				
				break;
			case "Mover742":
				Mover742 mover742 = new Mover742();
				mover742.setMobile(temp);
				break;
			case "Mover743":
				Mover743 mover743 = new Mover743();
				mover743.setMobile(temp);
				break;
			case "Mover744":
				Mover744 mover744 = new Mover744();
				mover744.setMobile(temp);
				break;
			case "Mover745":
				Mover745 mover745 = new Mover745();
				mover745.setMobile(temp);
				break;
			case "Mover752":
				Mover752 mover752 = new Mover752();
				mover752.setMobile(temp);
				break;
			case "Mover753":
				Mover753 mover753 = new Mover753();
				mover753.setMobile(temp);
				break;
			case "Mover755":
				Mover755 mover755 = new Mover755();
				mover755.setMobile(temp);
				break;
			case "Mover761":
				Mover761 mover761 = new Mover761();
				mover761.setMobile(temp);
				break;
			case "Mover762":
				Mover762 mover762 = new Mover762();
				mover762.setMobile(temp);
				break;
			case "Mover763":
				Mover763 mover763 = new Mover763();
				mover763.setMobile(temp);
				break;
			case "Mover764":
				Mover764 mover764 = new Mover764();
				mover764.setMobile(temp);
				break;
			case "Mover765":
				Mover765 mover765 = new Mover765();
				mover765.setMobile(temp);
				break;
			case "Mover766":
				Mover766 mover766 = new Mover766();
				mover766.setMobile(temp);
				break;
			case "Mover767":
				Mover767 mover767 = new Mover767();
				mover767.setMobile(temp);
				break;
			case "Mover800":
				Mover800 mover800 = new Mover800();
				mover800.setMobile(temp);
				break;
			case "Mover801":
				Mover801 mover801 = new Mover801();
				mover801.setMobile(temp);
				break;
			case "Mover802":
				Mover802 mover802 = new Mover802();
				mover802.setMobile(temp);
				break;
			case "Mover815":
				Mover815 mover815 = new Mover815();
				mover815.setMobile(temp);
				break;
			case "Mover816":
				Mover816 mover816 = new Mover816();
				mover816.setMobile(temp);
				break;
			case "Mover870":
				Mover870 mover870 = new Mover870();
				mover870.setMobile(temp);
				break;
			case "Mover871":
				Mover871 mover871 = new Mover871();
				mover871.setMobile(temp);
				break;
			case "Mover899":
				Mover899 mover899 = new Mover899();
				mover899.setMobile(temp);
				break;
			case "Mover1":
				Mover1 mover1 = new Mover1();
				mover1.setMobile(temp);
				break;
			case "Mover2":
				Mover2 mover2 = new Mover2();
				mover2.setMobile(temp);
				break;
			case "Mover3":
				Mover3 mover3 = new Mover3();
				mover3.setMobile(temp);
				break;
			case "Mover4":
				Mover4 mover4 = new Mover4();
				mover4.setMobile(temp);
				break;
			case "Mover5":
				Mover5 mover5 = new Mover5();
				mover5.setMobile(temp);
				break;
			case "Mover6":
				Mover6 mover6 = new Mover6();
				mover6.setMobile(temp);
				break;
			case "Mover7":
				Mover7 mover7 = new Mover7();
				mover7.setMobile(temp);
				break;
			case "Mover8":
				Mover8 mover8 = new Mover8();
				mover8.setMobile(temp);
				break;
			case "Mover9":
				Mover9 mover9 = new Mover9();
				mover9.setMobile(temp);
				break;
			case "Mover10":
				Mover10 mover10 = new Mover10();
				mover10.setMobile(temp);
				break;
			case "Mover900":
				Mover900 mover900 = new Mover900();
				mover900.setMobile(temp);
				break;
			case "Mover901":
				Mover901 mover901 = new Mover901();
				mover901.setMobile(temp);
				break;
			case "Mover907":
				Mover907 mover907 = new Mover907();
				mover907.setMobile(temp);
				break;
			case "Mover910":
				Mover910 mover910 = new Mover910();
				mover910.setMobile(temp);
				break;
			case "Mover911":
				Mover911 mover911 = new Mover911();
				mover911.setMobile(temp);
				break;
			case "Mover913":
				Mover913 mover913 = new Mover913();
				mover913.setMobile(temp);
				break;
			case "Mover914":
				Mover914 mover914 = new Mover914();
				mover914.setMobile(temp);
				break;
			case "Mover915":
				Mover915 mover915 = new Mover915();
				mover915.setMobile(temp);
				break;
			case "Mover916":
				Mover916 mover916 = new Mover916();
				mover916.setMobile(temp);
				break;
			case "Mover917":
				Mover917 mover917 = new Mover917();
				mover917.setMobile(temp);
				break;
			case "Mover918":
				Mover918 mover918 = new Mover918();
				mover918.setMobile(temp);
				break;
			case "Mover919":
				Mover919 mover919 = new Mover919();
				mover919.setMobile(temp);
				break;
			case "Mover920":
				Mover920 mover920 = new Mover920();
				mover920.setMobile(temp);
				break;
			case "Mover921":
				Mover921 mover921 = new Mover921();
				mover921.setMobile(temp);
				break;
			case "Mover922":
				Mover922 mover922 = new Mover922();
				mover922.setMobile(temp);
				break;
			case "Mover923":
				Mover923 mover923 = new Mover923();
				mover923.setMobile(temp);
				break;
			case "Mover924":
				Mover924 mover924 = new Mover924();
				mover924.setMobile(temp);
				break;
			case "Mover925":
				Mover925 mover925 = new Mover925();
				mover925.setMobile(temp);
				break;
			case "Mover926":
				Mover926 mover926 = new Mover926();
				mover926.setMobile(temp);
				break;
			case "Mover927":
				Mover927 mover927 = new Mover927();
				mover927.setMobile(temp);
				break;
			case "Mover928":
				Mover928 mover928 = new Mover928();
				mover928.setMobile(temp);
				break;
			case "Mover929":
				Mover929 mover929 = new Mover929();
				mover929.setMobile(temp);
				break;
			case "Mover930":
				Mover930 mover930 = new Mover930();
				mover930.setMobile(temp);
				break;
			case "Mover931":
				Mover931 mover931 = new Mover931();
				mover931.setMobile(temp);
				break;
			case "Mover932":
				Mover932 mover932 = new Mover932();
				mover932.setMobile(temp);
				break;
			case "Mover933":
				Mover933 mover933 = new Mover933();
				mover933.setMobile(temp);
				break;
			case "Mover934":
				Mover934 mover934 = new Mover934();
				mover934.setMobile(temp);
				break;
			case "Mover941":
				Mover941 mover941 = new Mover941();
				mover941.setMobile(temp);
				break;
			case "Mover942":
				Mover942 mover942 = new Mover942();
				mover942.setMobile(temp);
				break;
		}
		
		return specificStrategy;		
	}
}
