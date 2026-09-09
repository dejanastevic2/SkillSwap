import Link from "next/link";

export default function Header() {
    return(
        <header>
            <div className="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
                <Link href="/" className="d-flex align-items-center text-dark text-decoration-none">
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" className="me-2" viewBox="0 0 118 94" role="img"></svg>
                    <span className="fs-4">ISA Template</span>
                </Link>

                <nav className="d-inline-flex mt-2 mt-md-0 ms-md-auto">
                    <Link href="/user/list" className="me-3 py-2 text-dark text-decoration-none">Users</Link>
                    <Link href="/user/create" className="me-3 py-2 text-dark text-decoration-none">User Create</Link>
                </nav>
            </div>
        </header>
    );
}