import { useLocation, useNavigate } from "react-router";
import { Link } from "react-router-dom";
import { useAuth } from "src/features/auth";
import { ProfileIcon } from "../ui";

interface Props {
  currentPage: string;
  showNavigation?: boolean;
}

export function NavBar({ currentPage, showNavigation = true }: Props) {
  const auth = useAuth();

  return (
    <nav className="navbar navbar-expand-lg navbar-light fw-bold">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">
          oneforum
        </Link>
        {showNavigation && (
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
        )}
        {showNavigation && (
          <div className="collapse navbar-collapse" id="navbarNavDropdown">
            <ul className="navbar-nav align-items-md-center  align-items-start gap-2">
              <li className="nav-item">
                <Link
                  className={`nav-link ${currentPage == "home" && "active"}`}
                  to="/"
                >
                  Home
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className={`nav-link ${
                    currentPage == "all-topic" && "active"
                  }`}
                  to="/all-topic"
                >
                  All Topic
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className={`nav-link ${
                    currentPage == "post-question" && "active"
                  }`}
                  to={auth.isAuth() ? "/post-question" : "/login"}
                >
                  New Question
                </Link>
              </li>

              {!auth.isAuth() && (
                <li className="nav-item">
                  <Link className={`nav-link`} to="/login">
                    Login
                  </Link>
                </li>
              )}

              {auth.isAuth() && (
                <li className="nav-item dropdown">
                  <a
                    className="nav-link dropdown-toggle text-capitalize d-flex flex-wrap gap-1 align-items-center"
                    href="#"
                    id="navbarDropdownMenuLink"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    {/* <span className="">{auth.currentAuthData.user.name}</span> */}
                    <ProfileIcon
                      size="30px"
                      fontSize="15px"
                      username={auth.currentAuthData.user.name}
                    />
                  </a>
                  <ul
                    className="dropdown-menu"
                    aria-labelledby="navbarDropdownMenuLink"
                  >
                    <li>
                      <Link
                        className="dropdown-item"
                        to={`/profile/${auth.currentAuthData.user.uid}`}
                      >
                        View Profile
                      </Link>
                    </li>
                    <li>
                      <Link
                        className="dropdown-item text-danger"
                        to="/login"
                        onClick={() => {
                          auth.logout();
                        }}
                      >
                        Logout
                      </Link>
                    </li>
                  </ul>
                </li>
              )}
            </ul>
          </div>
        )}
      </div>
    </nav>
  );
}
