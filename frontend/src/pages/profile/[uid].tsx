import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { useAuth } from "src/features/auth";
import { User } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { NavBar } from "src/features/nav-bar";
import { PaginatedUserQuestionList } from "src/features/paginated-list";
import { AppContainer, SpacingBox } from "src/features/ui";
import { extractProfileText } from "src/features/utils";

export function ProfilePage() {
  const { uid } = useParams();

  const auth = useAuth();
  const axios = useAxios();

  const [user, setUser] = useState<User | null>(null);

  const fetchUser = async () => {
    try {
      const response = await axios.get(`/user/${uid}`);
      setUser(response.data as User);
    } catch {
      setUser(null);
    }
  };

  useEffect(() => {
    fetchUser();
  }, [uid]);

  return (
    <>
      <NavBar currentPage="profile-page"/>
      <SpacingBox />
      <AppContainer>
        {user && (
          <>
            <div className="w-100 d-flex flex-column align-items-center justify-content-center mb-3">
              <div
                className="d-flex justify-content-center align-items-center rounded-circle bg-dark text-white fs-1 mb-3"
                style={{ width: "150px", height: "150px" }}
              >
                {extractProfileText(user.name)}
              </div>
              <h1 className="fs-1 p-0 m-0 fw-bold d-flex flex-wrap align-items-center text-center">
                {user.name}
                {auth.currentAuthData.user.uid == user.uid && (
                  <span className="badge bg-warning text fs-6 ms-2 rounded-pill">
                    You
                  </span>
                )}
              </h1>
            </div>
            <div>
              <PaginatedUserQuestionList uid={user.uid} />
            </div>
          </>
        )}

        {!user == undefined && <p>404! user not found</p>}
      </AppContainer>
    </>
  );
}
